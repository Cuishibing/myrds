package cui.shibing.rdsserver.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QTRdsUser is a Querydsl query type for TRdsUser
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QTRdsUser extends com.querydsl.sql.RelationalPathBase<TRdsUser> {

    private static final long serialVersionUID = 1796495176;

    public static final QTRdsUser tRdsUser = new QTRdsUser("t_rds_user");

    public final StringPath account = createString("account");

    public final NumberPath<Long> ctime = createNumber("ctime", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final NumberPath<Long> utime = createNumber("utime", Long.class);

    public final NumberPath<Integer> valid = createNumber("valid", Integer.class);

    public final com.querydsl.sql.PrimaryKey<TRdsUser> primary = createPrimaryKey(id);

    public QTRdsUser(String variable) {
        super(TRdsUser.class, forVariable(variable), "null", "t_rds_user");
        addMetadata();
    }

    public QTRdsUser(String variable, String schema, String table) {
        super(TRdsUser.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QTRdsUser(String variable, String schema) {
        super(TRdsUser.class, forVariable(variable), schema, "t_rds_user");
        addMetadata();
    }

    public QTRdsUser(Path<? extends TRdsUser> path) {
        super(path.getType(), path.getMetadata(), "null", "t_rds_user");
        addMetadata();
    }

    public QTRdsUser(PathMetadata metadata) {
        super(TRdsUser.class, metadata, "null", "t_rds_user");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(account, ColumnMetadata.named("account").withIndex(3).ofType(Types.VARCHAR).withSize(32).notNull());
        addMetadata(ctime, ColumnMetadata.named("ctime").withIndex(6).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(name, ColumnMetadata.named("name").withIndex(2).ofType(Types.VARCHAR).withSize(32).notNull());
        addMetadata(password, ColumnMetadata.named("password").withIndex(4).ofType(Types.VARCHAR).withSize(128).notNull());
        addMetadata(utime, ColumnMetadata.named("utime").withIndex(7).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(valid, ColumnMetadata.named("valid").withIndex(5).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

