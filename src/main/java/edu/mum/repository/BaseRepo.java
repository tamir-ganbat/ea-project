package edu.mum.repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 985927 on 11/20/2017
 */
public interface BaseRepo<D, ID extends Serializable> {

    D get(ID id);

    D merge(D item);

    void refresh(D item);

    ID save(D item);

    void saveOrUpdate(D item);

    void update(D item);

    void delete(D item);

    List<D> find();
}
