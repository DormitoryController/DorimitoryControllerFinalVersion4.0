package com.dormitory.model.po;

/**
 * Created by war on 2017/4/17.
 */
public class Item {
        private int id;
        private String name;
        private int repertory;
        private String price;

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public int getRepertory() {
                return repertory;
        }

        public void setRepertory(int repertory) {
                this.repertory = repertory;
        }

        public String getPrice() {
                return price;
        }

        public void setPrice(String price) {
                this.price = price;
        }

        public int getId() {

                return id;
        }

        public void setId(int id) {
                this.id = id;
        }
}
