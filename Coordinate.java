public class Coordinate {
    private final int rows;
    private final int columns;

    /*
     * This is the constructor for the coordinate class
     */
    public Coordinate(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
    }

    public int getRow(){
        return rows;
    }
    public int getColumns(){
        return columns;
    }


    /**
     * 
     */
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Coordinate that =(Coordinate) obj;
        return rows == that.rows && columns == that.columns;

    }

}
