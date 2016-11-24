/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FBLT.domain.product.category;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Admin
 */
public class FindProductCatagory {

    private final BufferedReader bufferedReader;
    private List<String> description;
    private List<String> possibleCatagories;
   
    private FindProductCatagory(Builder builder) {
        this.bufferedReader = builder.bufferedReader;
    }

    public  String getFirstCategory() throws Exception {
        return possibleCatagories.get(0);
    }
    
    public void processCatagoryFile() throws Exception {       
        possibleCatagories = new ArrayList<>();
        
        int position = 0;
        String line;
        
        while((line = bufferedReader.readLine()) != null) {
            
           for (String word : line.split(" ")) {
                
               for (int i = 0; i < description.size(); i++){
                    if(word.equals(description.get(i))) {
                        
                        if(!possibleCatagories.contains(line.split(" ")[0]))
                            possibleCatagories.add(line.split(" ")[0]);
                    }
               }
                
               position++;
           }
           
           position = 0;
        }
    }
    
    public String getCatagory() {
        String catagoryList = "";
        
        for (String catagory : possibleCatagories) {
            catagoryList += catagory + " ";
        }
        
        return catagoryList;
    }
    
    public void processDescription(String description) {    
        String[] words = description.split(" ");
        
        this.description = new ArrayList<>();
        this.description.addAll(Arrays.asList(words));
    }

    public void closeConnections() throws Exception {
        bufferedReader.close();
    }
    
    public String analyseDescription() {
        return this.description.get(0);
    }
    
    public static class Builder {

        private BufferedReader bufferedReader;

        public Builder setBufferedReader(BufferedReader bufferedReader) {
            this.bufferedReader = bufferedReader;
            return this;
        }
        
        public Builder copyFindProductCatagory(FindProductCatagory findProCat) {
            this.bufferedReader = findProCat.bufferedReader;
            return this;
        }
        
        public FindProductCatagory build() {
            return new FindProductCatagory(this);
        }        
    }
}
