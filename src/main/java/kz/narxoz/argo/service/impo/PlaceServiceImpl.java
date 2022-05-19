package kz.narxoz.argo.service.impo;

import kz.narxoz.argo.entity.Place;
import kz.narxoz.argo.repository.PlaceRepository;
import kz.narxoz.argo.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    PlaceRepository placeRepository;

    @Override
    public List<Place> findAllPlace(){
        return placeRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Place savePlace(Place place){
        return placeRepository.save(place);
    }

    @Override
    public Place findPlace(Long id){
        return placeRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePlace(Long id){
        placeRepository.deleteById(id);
    }

}
