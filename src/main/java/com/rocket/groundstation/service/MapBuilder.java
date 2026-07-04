package com.rocket.groundstation.service;

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
import org.mapsforge.map.layer.renderer.TileRendererLayer;
import org.mapsforge.map.reader.MapFile;
import org.mapsforge.map.reader.header.MapFileException;
import org.mapsforge.map.rendertheme.ExternalRenderTheme;
import org.mapsforge.map.rendertheme.internal.MapsforgeThemes;


public class MapBuilder {
    
    public MapView buildMap(Path mapPath, Path renderThemePath) throws InvalidPathException{
        if(mapPath==null){
            throw new InvalidPathException("Map path can't be null", "null");
        }
        
        MapView map = new MapView();
        
        File cacheDirectory = new File("maps/cache");
        cacheDirectory.mkdir();
        
        TileCache tileCache = AwtUtil.createTileCache(
            map.getModel().displayModel.getTileSize(),
            1.0,
            1024,
            cacheDirectory
        );
        
        MapDataStore mapDataStore;
        try{
            mapDataStore = new MapFile(mapPath.toFile());
        }catch(MapFileException ex){
            throw new InvalidPathException("Invalid map path", mapPath.toString());
        }
        
        TileRendererLayer tileRendererLayer = new TileRendererLayer(
                tileCache,
                mapDataStore,
                map.getModel().mapViewPosition,
                false, true, false,
                AwtGraphicFactory.INSTANCE                
        );
        
        try{
            tileRendererLayer.setXmlRenderTheme(new ExternalRenderTheme(renderThemePath.toFile()));
            map.getModel().displayModel.setUserScaleFactor(1.6f);
        } catch(FileNotFoundException | NullPointerException ex){
            tileRendererLayer.setXmlRenderTheme(MapsforgeThemes.BIKER);
            map.getModel().displayModel.setUserScaleFactor(1.3f);
        }
        
        map.getLayerManager().getLayers().add(tileRendererLayer);        
        
        map.getModel().mapViewPosition.setCenter(
                new LatLong(-21.886998, -49.083419)
        );
        
        map.getModel().mapViewPosition.setZoomLevelMin((byte) 6);
        
        map.getModel().mapViewPosition.setZoomLevel((byte) 10);
        
        return map;
    }
}
