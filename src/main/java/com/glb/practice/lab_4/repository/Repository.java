package com.glb.practice.lab_4.repository;

import java.util.List;

import com.glb.practice.lab_4.model.ShortBook;

public interface Repository {
   
public List<ShortBook> get_k_n_shortList(int k,int n) throws Exception;

} 