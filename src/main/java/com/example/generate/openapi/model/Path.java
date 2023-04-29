package com.example.generate.openapi.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Data
public class Path {
   Operation get;
   Operation post;
   Operation put;
   Operation delete;
   Operation patch;

   public List<Operation> getOperations() {
      List<Operation> ops = new ArrayList<>();
      Optional.ofNullable(get).ifPresent(ops::add);
      Optional.ofNullable(post).ifPresent(ops::add);
      Optional.ofNullable(put).ifPresent(ops::add);
      Optional.ofNullable(delete).ifPresent(ops::add);
      Optional.ofNullable(patch).ifPresent(ops::add);
      return ops;
   }

}
