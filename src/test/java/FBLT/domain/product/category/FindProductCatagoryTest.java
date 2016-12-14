/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FBLT.domain.product.category;

import FBLT.factories.category.FindProductCatagoryFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * @author Twaha Nzeyimana
 * @date 21 Septemeber 2016
 * @description A simple algorithms to find product categories according to user input
 */
public class FindProductCatagoryTest {

    private FindProductCatagory findProductCatagory;
    private String TAG = "FindProductCatagory: ";
    private static final String FILE = "categories_text.txt";

    @Before
    public void setup() throws Exception {

        BufferedWriter dummyWriter = new BufferedWriter(new FileWriter(FILE));

        dummyWriter.write(
                "Livestock cow cows chickens chicken birds bird sheep sheeps goat goats\n" +
                        "Cellphone phones phone samsung android iphone\n" +
                        "Electronics phones phone speakers mic mics earphone earphones beats"
        );

        dummyWriter.close();

        StringReader stringReader = new StringReader("Livestock cow cows chickens chicken birds bird sheep sheeps goat goats\n" +
                "Cellphone phones phone samsung android iphone\n" +
                "Electronics phones phone speakers mic mics earphone earphones beats");

        BufferedReader br = new BufferedReader(stringReader);

        System.out.print(br.readLine());

        findProductCatagory = FindProductCatagoryFactory
                .getFindProductCatagory(br);
    }

    @Test
    public void whenTheUserEntersADescription_getAllTheCatagories() throws
            Exception {

        findProductCatagory.processDescription("Hey there, I am selling an "
                + "android phone S4 and a pair of Beats earphones.");
        findProductCatagory.processCatagoryFile();

        String list = findProductCatagory.getCatagory();

        findProductCatagory.closeConnections();

        Assert.assertEquals(TAG, "Cellphone Electronics", list.trim());
    }

    @After
    public void cleanup() {

        Assert.assertTrue(new File(FILE).exists());

        boolean isFileDeleted = new File(FILE).delete();

        Assert.assertTrue(TAG, isFileDeleted);
    }
}
