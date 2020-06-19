package test1;

public class Key {

        private String id;

    public String getId() {
        return id;
    }

    public Key(String id) {
        this.id = id;
    }

            public boolean equals(Object o){
            if (o==null||!(o instanceof Key))
            {return false;}
            else
            {return this.getId().equals(((Key) o).getId());}
        }

        public int hashCode(){
            return id.hashCode();
        }

}
