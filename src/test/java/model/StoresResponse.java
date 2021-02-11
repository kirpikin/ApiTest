package model;

import java.util.List;

public class StoresResponse {
    private String type;
    private int limit;
    private int count;
    private int offset;
    private int total;
    private List<Data> data;

    public class Data {
        private int id;
        private String name;
        private String address;
        private String city_id;
        private String city_name;
        private int region_id;
        private String region_name;
        private String store_type_id;
        private String store_type_name;
        private String segment_id;
        private String external_id;
        private String external_id2;
        private String territory1_id;
        private String territory;
        private String retailer_id;
        private String retailer_name;
        private double lon;
        private double lat;
        private String category;
        private String type;
        private int active_matrices_count;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public String getCity_id() {
            return city_id;
        }

        public String getCity_name() {
            return city_name;
        }

        public int getRegion_id() {
            return region_id;
        }

        public String getRegion_name() {
            return region_name;
        }

        public String getStore_type_id() {
            return store_type_id;
        }

        public String getStore_type_name() {
            return store_type_name;
        }

        public String getSegment_id() {
            return segment_id;
        }

        public String getExternal_id() {
            return external_id;
        }

        public String getExternal_id2() {
            return external_id2;
        }

        public String getTerritory1_id() {
            return territory1_id;
        }

        public String getTerritory() {
            return territory;
        }

        public String getRetailer_id() {
            return retailer_id;
        }

        public String getRetailer_name() {
            return retailer_name;
        }

        public double getLon() {
            return lon;
        }

        public double getLat() {
            return lat;
        }

        public String getCategory() {
            return category;
        }

        public String getType() {
            return type;
        }

        public int getActive_matrices_count() {
            return active_matrices_count;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    ", city_id='" + city_id + '\'' +
                    ", city_name='" + city_name + '\'' +
                    ", region_id=" + region_id +
                    ", region_name='" + region_name + '\'' +
                    ", store_type_id='" + store_type_id + '\'' +
                    ", store_type_name='" + store_type_name + '\'' +
                    ", segment_id='" + segment_id + '\'' +
                    ", external_id='" + external_id + '\'' +
                    ", external_id2='" + external_id2 + '\'' +
                    ", territory1_id='" + territory1_id + '\'' +
                    ", territory='" + territory + '\'' +
                    ", retailer_id='" + retailer_id + '\'' +
                    ", retailer_name='" + retailer_name + '\'' +
                    ", lon=" + lon +
                    ", lat=" + lat +
                    ", category='" + category + '\'' +
                    ", type='" + type + '\'' +
                    ", active_matrices_count=" + active_matrices_count +
                    '}';
        }
    }

    public String getType() {
        return type;
    }

    public int getLimit() {
        return limit;
    }

    public int getCount() {
        return count;
    }

    public int getOffset() {
        return offset;
    }

    public int getTotal() {
        return total;
    }

    public List<Data> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "StoresResponse{" +
                "type='" + type + '\'' +
                ", limit=" + limit +
                ", count=" + count +
                ", offset=" + offset +
                ", total=" + total +
                ", date=" + data +
                '}';
    }
}
