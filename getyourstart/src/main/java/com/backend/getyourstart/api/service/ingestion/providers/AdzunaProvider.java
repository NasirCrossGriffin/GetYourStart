package com.backend.getyourstart.api.service.ingestion.providers;

import com.backend.getyourstart.helpers.AdzunaRequestHelper;
 
public class AdzunaProvider {
    private final AdzunaRequestHelper adzunaRequestHelper;

    public AdzunaProvider(AdzunaRequestHelper adzunaRequestHelper) {
        this.adzunaRequestHelper = adzunaRequestHelper;
    }

}
