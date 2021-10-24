package cui.shibing.rdsserver.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QTRdsDatabaseInfo is a Querydsl query type for TRdsDatabaseInfo
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QTRdsDatabaseInfo extends com.querydsl.sql.RelationalPathBase<TRdsDatabaseInfo> {

    private static final long serialVersionUID = 575492934;

    public static final QTRdsDatabaseInfo tRdsDatabaseInfo = new QTRdsDatabaseInfo("t_rds_database_info");

    public final NumberPath<Long> ctime = createNumber("ctime", Long.class);

    public final StringPath defaultDb = createString("defaultDb");

    public final StringPath host = createString("host");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath password = createString("password");

    public final NumberPath<Integer> port = createNumber("port", Integer.class);

    public final NumberPath<Long> utime = createNumber("utime", Long.class);

    public final NumberPath<Integer> valid = createNumber("valid", Integer.class);

    public final com.querydsl.sql.PrimaryKey<TRdsDatabaseInfo> primary = createPrimaryKey(id);

    public QTRdsDatabaseInfo(String variable) {
        super(TRdsDatabaseInfo.class, forVariable(variable), "null", "t_rds_database_info");
        addMetadata();
    }

    public QTRdsDatabaseInfo(String variable, String schema, String table) {
        super(TRdsDatabaseInfo.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QTRdsDatabaseInfo(String variable, String schema) {
        super(TRdsDatabaseInfo.class, forVariable(variable), schema, "t_rds_database_info");
        addMetadata();
    }

    public QTRdsDatabaseInfo(Path<? extends TRdsDatabaseInfo> path) {
        super(path.getType(), path.getMetadata(), "null", "t_rds_database_info");
        addMetadata();
    }

    public QTRdsDatabaseInfo(PathMetadata metadata) {
        super(TRdsDatabaseInfo.class, metadata, "null", "t_rds_database_info");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(ctime, ColumnMetadata.named("ctime").withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(defaultDb, ColumnMetadata.named("default_db").withIndex(4).ofType(Types.VARCHAR).withSize(128).notNull());
        addMetadata(host, ColumnMetadata.named("host").withIndex(2).ofType(Types.VARCHAR).withSize(128).notNull());
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(password, ColumnMetadata.named("password").withIndex(5).ofType(Types.VARCHAR).withSize(128).notNull());
        addMetadata(port, ColumnMetadata.named("port").withIndex(3).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(utime, ColumnMetadata.named("utime").withIndex(8).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(valid, ColumnMetadata.named("valid").withIndex(6).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

