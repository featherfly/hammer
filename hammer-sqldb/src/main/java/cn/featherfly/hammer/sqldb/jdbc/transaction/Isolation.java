package cn.featherfly.hammer.sqldb.jdbc.transaction;

import java.sql.Connection;

public enum Isolation {
    /**
     * A constant indicating that transactions are not supported.
     */
    NONE(Connection.TRANSACTION_NONE),
    /**
     * A constant indicating that dirty reads, non-repeatable reads and phantom
     * reads can occur. This level allows a row changed by one transaction to be
     * read by another transaction before any changes in that row have been
     * committed (a "dirty read"). If any of the changes are rolled back, the
     * second transaction will have retrieved an invalid row.
     */
    READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),

    /**
     * A constant indicating that dirty reads are prevented; non-repeatable
     * reads and phantom reads can occur. This level only prohibits a
     * transaction from reading a row with uncommitted changes in it.
     */
    READ_COMMITTED(Connection.TRANSACTION_READ_COMMITTED),
    /**
     * A constant indicating that dirty reads and non-repeatable reads are
     * prevented; phantom reads can occur. This level prohibits a transaction
     * from reading a row with uncommitted changes in it, and it also prohibits
     * the situation where one transaction reads a row, a second transaction
     * alters the row, and the first transaction rereads the row, getting
     * different values the second time (a "non-repeatable read").
     */
    REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),
    /**
     * A constant indicating that dirty reads, non-repeatable reads and phantom
     * reads are prevented. This level includes the prohibitions in
     * <code>TRANSACTION_REPEATABLE_READ</code> and further prohibits the
     * situation where one transaction reads all rows that satisfy a
     * <code>WHERE</code> condition, a second transaction inserts a row that
     * satisfies that <code>WHERE</code> condition, and the first transaction
     * rereads for the same condition, retrieving the additional "phantom" row
     * in the second read.
     */
    SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE);

    private int value;

    Isolation(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}