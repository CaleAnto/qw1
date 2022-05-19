package kz.narxoz.argo.service;

import kz.narxoz.argo.entity.Place;

import java.util.List;

public interface PlaceService {

    List<Place> findAllPlace();

    Place savePlace(Place place);

    Place findPlace(Long id);

    void deletePlace(Long id);

}
