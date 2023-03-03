package ch.noseryoung.blj;

public interface BaseCollection {
    int getNumberOfElem();
    boolean isElem(int elem);
    void addElem(int elem) throws Exception;
}
