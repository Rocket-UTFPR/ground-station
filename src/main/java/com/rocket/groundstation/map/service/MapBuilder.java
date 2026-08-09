package com.rocket.groundstation.map.service;

import com.rocket.groundstation.exceptions.InvalidPathException;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.map.awt.graphics.AwtGraphicFactory;
import org.mapsforge.map.awt.util.AwtUtil;
import org.mapsforge.map.awt.view.MapView;
import org.mapsforge.map.datastore.MapDataStore;
import org.mapsforge.map.layer.cache.TileCache;
import org.mapsforge.map.layer.download.TileDownloadLayer;
import org.mapsforge.map.layer.hills.DemFolder;
import org.mapsforge.map.layer.hills.DemFolderFS;
import org.mapsforge.map.layer.hills.DiffuseLightShadingAlgorithm;
import org.mapsforge.map.layer.hills.HillsRenderConfig;
import org.mapsforge.map.layer.hills.MemoryCachingHgtReaderTileSource;
import org.mapsforge.map.layer.renderer.TileRendererLayer;
import org.mapsforge.map.reader.MapFile;
import org.mapsforge.map.reader.header.MapFileException;
import org.mapsforge.map.rendertheme.ExternalRenderTheme;
import org.mapsforge.map.rendertheme.internal.MapsforgeThemes;


public class MapBuilder {
    private MapView map;
    
    private TileRendererLayer normalLayer;
    private TileRendererLayer transparentLayer;
    private TileDownloadLayer satelliteLayer;
    
    private HillsRenderConfig hillsConfig;
    private Path renderThemePath;
    private Path satRenderThemePath;
    private MapDataStore mapDataStore;
    private TileCache nlTileCache;
    private TileCache tlTileCache;
    
    private float normalScaleFactor;
    private float satScaleFactor;
    
    
    public MapBuilder(Path mapPath, Path renderThemePath, Path satRenderThemePath) throws InvalidPathException{
        if(mapPath==null) throw new InvalidPathException("Map path can't be null", "null");
        
        this.renderThemePath = renderThemePath;
        this.satRenderThemePath = satRenderThemePath;
        satScaleFactor = 1f;
        normalScaleFactor = 1f;
        
        map = new MapView();
        mapSetup(mapPath);
    }
    
    public MapView getMap(){
        return map;
    }
    
    public float getNormalScaleFactor() {
        return normalScaleFactor;
    }
    
    public float getSatScaleFactor() {
        return satScaleFactor;
    }
    
    public void setNormalScaleFactor(float normalScaleFactor) {
        this.normalScaleFactor = normalScaleFactor;
        map.getModel().displayModel.setUserScaleFactor(normalScaleFactor);
    }
    
    public void setSatScaleFactor(float satScaleFactor) {
        this.satScaleFactor = satScaleFactor;
        map.getModel().displayModel.setUserScaleFactor(satScaleFactor);
    }
    
    public void addSatLayer(){
        if(satScaleFactor!=normalScaleFactor) map.getModel().displayModel.setUserScaleFactor(satScaleFactor);
        normalLayer.setVisible(false);
        
        satelliteLayer.onResume();
        satelliteLayer.setVisible(true);
        transparentLayer.setVisible(true);
    }
    
    public void removeSatLayer(){
        if(satScaleFactor!=normalScaleFactor) map.getModel().displayModel.setUserScaleFactor(normalScaleFactor);
        normalLayer.setVisible(true);
        
        satelliteLayer.setVisible(false);
        transparentLayer.setVisible(false);
        satelliteLayer.onPause();
    }
    
    public void changeMap(Path newMapPath) throws InvalidPathException{
        if(newMapPath==null) throw new InvalidPathException("New map path can't be null", "null");
        
        MapDataStore newMapDataStore;
        try{
            newMapDataStore = new MapFile(newMapPath.toFile());
        } catch(MapFileException ex){
            throw new InvalidPathException("Invalid map path", newMapPath.toString());
        }
        if(this.mapDataStore!=null) this.mapDataStore.close();
        this.mapDataStore = newMapDataStore;
        boolean isSatVisible = satelliteLayer.isVisible();
        
        map.getLayerManager().getLayers().remove(normalLayer);
        map.getLayerManager().getLayers().remove(transparentLayer);
        if (this.nlTileCache != null) this.nlTileCache.purge();
        if (this.tlTileCache != null) this.tlTileCache.purge();
        normalLayer.onDestroy();
        transparentLayer.onDestroy();
        
        mapLayersSetup();
        
        normalLayer.setVisible(!isSatVisible);
        transparentLayer.setVisible(isSatVisible);
        
        map.getLayerManager().getLayers().add(0, normalLayer);
        map.getLayerManager().getLayers().add(2, transparentLayer);
        
        normalLayer.requestRedraw();
        transparentLayer.requestRedraw();
    }
    
    private void mapSetup(Path mapPath) throws InvalidPathException{
        new File("maps/cache").mkdirs();
        new File("maps/themes").mkdirs();
        new File("maps/hgt").mkdirs();
        
        try{
            mapDataStore = new MapFile(mapPath.toFile());
        }catch(MapFileException ex){
            throw new InvalidPathException("Invalid map path", mapPath.toString());
        }
        
        DemFolder demFolder = new DemFolderFS(new File("maps/hgt"));
        MemoryCachingHgtReaderTileSource hgtSource = new MemoryCachingHgtReaderTileSource(
                demFolder,
                new DiffuseLightShadingAlgorithm(),
                AwtGraphicFactory.INSTANCE
        );

        hillsConfig = new HillsRenderConfig(hgtSource);
        hillsConfig.indexOnThread();
        
        File nlCacheDir = new File("maps/cache/n_cache");
        nlCacheDir.mkdirs();
        nlTileCache = AwtUtil.createTileCache(map.getModel().displayModel.getTileSize(),
            1.0,
            1024,
            nlCacheDir
        );
        
        File tlCacheDir = new File("maps/cache/t_cache");
        tlCacheDir.mkdirs();
        tlTileCache = AwtUtil.createTileCache(map.getModel().displayModel.getTileSize(),
            1.0,
            1024,
            tlCacheDir
        );
        
        mapLayersSetup();
        satLayerSetup();
        
        
        map.getLayerManager().getLayers().add(normalLayer);
        map.getLayerManager().getLayers().add(satelliteLayer);
        map.getLayerManager().getLayers().add(transparentLayer);
        satelliteLayer.setVisible(false);
        satelliteLayer.start();
        satelliteLayer.onPause();
        transparentLayer.setVisible(false);
        
        map.getModel().mapViewPosition.setCenter(
                new LatLong(-21.938391, -48.950188)
        );
        
        map.getModel().mapViewPosition.setZoomLevelMin((byte) 9);
        map.getModel().mapViewPosition.setZoomLevelMax((byte) 18);
        map.getModel().mapViewPosition.setZoomLevel((byte) 10);
    }
    
    private void mapLayersSetup(){
        normalLayer = new TileRendererLayer(
                nlTileCache,
                mapDataStore,
                map.getModel().mapViewPosition,
                false, true, false,
                AwtGraphicFactory.INSTANCE,
                hillsConfig
        );
        
        transparentLayer = new TileRendererLayer(
                tlTileCache,
                mapDataStore,
                map.getModel().mapViewPosition,
                true, true, false,
                AwtGraphicFactory.INSTANCE,
                hillsConfig
        );
        
        try{
            normalLayer.setXmlRenderTheme(new ExternalRenderTheme(renderThemePath.toFile()));
        } catch(FileNotFoundException | NullPointerException ex){
            normalLayer.setXmlRenderTheme(MapsforgeThemes.DEFAULT);
        }
        
        try {
            transparentLayer.setXmlRenderTheme(new ExternalRenderTheme(satRenderThemePath.toFile()));
        } catch (FileNotFoundException | NullPointerException ex) {
            transparentLayer.setXmlRenderTheme(MapsforgeThemes.DEFAULT);
        }
    }
    
    private void satLayerSetup(){
        File satelliteCacheDirectory = new File("maps/cache/satellite_cache");
        satelliteCacheDirectory.mkdirs();
        
        TileCache satelliteCache = AwtUtil.createTileCache(
                map.getModel().displayModel.getTileSize(),
                1.0,
                1024,
                satelliteCacheDirectory
        );
        
        satelliteLayer = new TileDownloadLayer(
                satelliteCache,
                map.getModel().mapViewPosition,
                new EsriSatelliteSource(),
                AwtGraphicFactory.INSTANCE
        );
    }
}
