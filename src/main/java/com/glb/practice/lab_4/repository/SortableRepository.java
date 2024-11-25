package com.glb.practice.lab_4.repository;

import java.io.IOException;
import java.util.List;

import com.glb.practice.lab_4.model.ShortBook;

public interface SortableRepository extends Repository {
    List<ShortBook> sort_get_k_n_shortList(int k, int n, String sort, int min, int max) throws IOException; ;
    
}
