package kz.narxoz.argo.service.impo;


import kz.narxoz.argo.entity.Book;
import kz.narxoz.argo.entity.Writer;
import kz.narxoz.argo.repository.WriterRepository;
import kz.narxoz.argo.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriterServiceImpl implements WriterService {

    @Autowired
    WriterRepository writerRepository;

    @Override
    public List<Writer> findAllWriter(){
        return writerRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Writer saveWriter(Writer writer){
        return writerRepository.save(writer);
    }

    @Override
    public Writer findWriter(Long id){
        return writerRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteWriter(Long id){
        writerRepository.deleteById(id);
    }

}
