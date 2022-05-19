package kz.narxoz.argo.service;

import kz.narxoz.argo.entity.Writer;

import java.util.List;

public interface WriterService {
    List<Writer> findAllWriter();

    Writer saveWriter(Writer writer);

    Writer findWriter(Long id);

    void deleteWriter(Long id);
}
