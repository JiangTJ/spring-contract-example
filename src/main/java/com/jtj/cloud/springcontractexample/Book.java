package com.jtj.cloud.springcontractexample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by MrTT (jiang.taojie@foxmail.com)
 * 2019/3/28.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String name;
    private int price;
}
