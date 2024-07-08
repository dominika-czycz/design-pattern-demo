package com.patterns.demo.structural.flyweight.application.model;

public enum AnimalType {
    CAT {
        @Override
        public GameObject createBasicAnimal() {
            return new BasicCat(getBasicBreed());
        }

        @Override
        public String getBasicBreed() {
            return "Main Coon";
        }
    }, DOG {
        @Override
        public GameObject createBasicAnimal() {
            return new BasicDog(getBasicBreed());
        }

        @Override
        public String getBasicBreed() {
            return "Labrador";
        }
    };


    public abstract GameObject createBasicAnimal();

    public abstract String getBasicBreed();
}
