package FBLT.factories.category;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import FBLT.domain.product.category.FindProductCatagory;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Admin
 */
public class FindProductCatagoryFactory {
    
    public static FindProductCatagory getFindProductCatagory(BufferedReader br,
                                                             FileReader fr) {
        return new FindProductCatagory.Builder()
                .setBufferedReader(br)
                .setFileReader(fr)
                .build();
    }
    
}
