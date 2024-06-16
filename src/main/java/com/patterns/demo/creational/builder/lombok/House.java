package com.patterns.demo.creational.builder.lombok;

import lombok.Getter;
import lombok.Setter;

/*
 * After @Builder Delombok operation
 * */

@Setter
@Getter
public class House {
    private String foundation;
    private String structure;
    private String roof;
    private boolean furnished;
    private boolean painted;

    House(String foundation, String structure, String roof, boolean furnished, boolean painted) {
        this.foundation = foundation;
        this.structure = structure;
        this.roof = roof;
        this.furnished = furnished;
        this.painted = painted;
    }

    public static HouseBuilder builder() {
        return new HouseBuilder();
    }

    public static class HouseBuilder {
        private String foundation;
        private String structure;
        private String roof;
        private boolean furnished;
        private boolean painted;

        HouseBuilder() {
        }

        public HouseBuilder foundation(String foundation) {
            this.foundation = foundation;
            return this;
        }

        public HouseBuilder structure(String structure) {
            this.structure = structure;
            return this;
        }

        public HouseBuilder roof(String roof) {
            this.roof = roof;
            return this;
        }

        public HouseBuilder furnished(boolean furnished) {
            this.furnished = furnished;
            return this;
        }

        public HouseBuilder painted(boolean painted) {
            this.painted = painted;
            return this;
        }

        public House build() {
            return new House(this.foundation, this.structure, this.roof, this.furnished, this.painted);
        }

        public String toString() {
            return "House.HouseBuilder(foundation=" + this.foundation + ", structure=" + this.structure + ", roof=" + this.roof + ", furnished=" + this.furnished + ", painted=" + this.painted + ")";
        }
    }
}
