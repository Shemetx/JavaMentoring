package com.epam.homework.task1;

public class MapKey {
        private Integer id;

        public MapKey(Integer id) {
            this.id = id;
        }
        @Override
        public int hashCode() {
            return id.hashCode();
        }

}
