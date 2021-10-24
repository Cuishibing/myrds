package cui.shibing.rdsserver.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QTRdsUserDatabaseInfo is a Querydsl query type for TRdsUserDatabaseInfo
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QTRdsUserDatabaseInfo extends com.querydsl.sql.RelationalPathBase<TRdsUserDatabaseInfo> {

    private static final long serialVersionUID = -141577167;

    public static final QTRdsUserDatabaseInfo tRdsUserDatabaseInfo = new QTRdsUserDatabaseInfo("t_rds_user_database_info");

    public final NumberPath<Long> ctime = createNumber("ctime", Long.class);

    public final NumberPath<Long> databaseInfoId = createNumber("databaseInfoId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final NumberPath<Long> utime = createNumber("utime", Long.class);

    public final NumberPath<Integer> valid = createNumber("valid", Integer.class);

    public final com.querydsl.sql.PrimaryKey<TRdsUserDatabaseInfo> primary = createPrimaryKey(id);

    public QTRdsUserDatabaseInfo(String variable) {
        super(TRdsUserDatabaseInfo.class, forVariable(variable), "null", "t_rds_user_database_info");
        addMetadata();
    }

    public QTRdsUserDatabaseInfo(String variable, String schema, String table) {
        super(TRdsUserDatabaseInfo.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QTRdsUserDatabaseInfo(String variable, String schema) {
        super(TRdsUserDatabaseInfo.class, forVariable(variable), schema, "t_rds_user_database_info");
        addMetadata();
    }

    public QTRdsUserDatabaseInfo(Path<? extends TRdsUserDatabaseInfo> path) {
        super(path.getType(), path.getMetadata(), "null", "t_rds_user_database_info");
        addMetadata();
    }

    public QTRdsUserDatabaseInfo(PathMetadata metadata) {
        super(TRdsUserDatabaseInfo.class, metadata, "null", "t_rds_user_database_info");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(ctime, ColumnMetadata.named("ctime").withIndex(5).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(databaseInfoId, ColumnMetadata.named("database_info_id").withIndex(3).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(userId, ColumnMetadata.named("user_id").withIndex(2).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(utime, ColumnMetadata.named("utime").withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(valid, ColumnMetadata.named("valid").withIndex(4).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

