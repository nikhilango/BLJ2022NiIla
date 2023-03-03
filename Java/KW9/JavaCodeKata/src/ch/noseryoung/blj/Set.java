package ch.noseryoung.blj;

public class Set implements BaseCollection{

    private int[] elements;
    private int dimension;
    private int count;

    public Set(int dimension) {
        this.dimension = dimension;
        this.count = 0;
        this.elements = new int[dimension];
    }

    @Override
    public int getNumberOfElem() {
        return count;
    }

    @Override
    public boolean isElem(int elem) {
        for (int i = 0; i < getNumberOfElem(); i++) {
            if (elements[i] == elem) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addElem(int elem) throws Exception {
        if (getNumberOfElem() >= dimension) {
            throw new Exception("There are more elements than the set dimension!");
        }
        elements[getNumberOfElem()] = elem;
        count++;
    }

    public Set union(Set set2) throws Exception {
        Set result = new Set(dimension);
        for (int i = 0; i < getNumberOfElem(); i++) {
            result.addElem(elements[i]);
        }
        for (int i = 0; i < set2.getNumberOfElem(); i++) {
            result.addElem(set2.elements[i]);
        }
        return result;
    }

    public Set intersection(Set set2) throws Exception {
        Set result = new Set(dimension);
        for (int i = 0; i < getNumberOfElem(); i++) {
            if (set2.isElem(elements[i])) {
                result.addElem(elements[i]);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < getNumberOfElem(); i++) {
            result = result + elements[i] + ", ";
        }
        return result;
    }
}
