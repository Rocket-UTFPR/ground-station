package com.rocket.groundstation.service;

import org.mapsforge.core.model.Tile;
import org.mapsforge.map.layer.download.tilesource.AbstractTileSource;
import java.net.MalformedURLException;
import java.net.URL;


public class EsriSatelliteSource extends AbstractTileSource {

    public EsriSatelliteSource() {
        super(
            new String[]{"services.arcgisonline.com"},
            443
        );
    }


    @Override
    public URL getTileUrl(Tile tile) throws MalformedURLException {

        String path =
                "/ArcGIS/rest/services/World_Imagery/MapServer/tile/"
                + tile.zoomLevel
                + "/"
                + tile.tileY
                + "/"
                + tile.tileX;


        return new URL(
                "https",
                "services.arcgisonline.com",
                path
        );
    }


    @Override
    public byte getZoomLevelMin() {
        return 1;
    }


    @Override
    public byte getZoomLevelMax() {
        return 18;
    }


    @Override
    public boolean hasAlpha() {
        return false;
    }

    @Override
    public int getParallelRequestsLimit() {
        return 4;
    }
}