package cn.featherfly.hammer.dsl;

public class QueryEntityRepository<T> extends EntityRepository<T> {

    private int index = 0;

    /**
     * @param index
     * @param type
     */
    public QueryEntityRepository(int index, Class<T> type) {
        super(type);
        this.index = index;
    }

    /**
     * get index value
     *
     * @return index
     */
    public int getIndex() {
        return index;
    }

}