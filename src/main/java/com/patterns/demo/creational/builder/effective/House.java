package com.patterns.demo.creational.builder.effective;


import lombok.NonNull;

public record House(@NonNull String foundation,
                    @NonNull String structure,
                    @NonNull String roof,
                    String windows,
                    String furnishes,
                    String paint) {

    public static class Builder {
        private final String foundation;
        private final String structure;
        private final String roof;
        private String windows;
        private String furnished;
        private String painted;

        public Builder(@NonNull String foundation, @NonNull String structure, @NonNull String roof) {
            this.foundation = foundation;
            this.structure = structure;
            this.roof = roof;
        }

        public Builder windows(@NonNull String windows) {
            this.windows = windows;
            return this;
        }

        public Builder furnished(@NonNull String furnished) {
            this.furnished = furnished;
            return this;
        }

        public Builder painted(@NonNull String painted) {
            this.painted = painted;
            return this;
        }

        public House build() {
            return new House(this.foundation, this.structure, this.roof, this.windows, this.furnished, this.painted);
        }

    }

}
