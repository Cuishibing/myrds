package cui.shibing.rdsserver.biz.command.runner;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Result {

    private List<String> columnNames;

    private List<List<String>> rows;

    public void excludeFields(List<String> fields) {
        if (CollectionUtils.isEmpty(fields) || CollectionUtils.isEmpty(columnNames)) {
            return;
        }
        List<Integer> targetIndex = new ArrayList<>();

        for (int i = 0; i < columnNames.size(); i++) {
            if (fields.contains(columnNames.get(i))) {
                targetIndex.add(i);
            }
        }

        if (CollectionUtils.isEmpty(targetIndex) || CollectionUtils.isEmpty(rows)) {
            return;
        }

        List<String> newColumnNames = new ArrayList<>();
        for (int i = 0; i < columnNames.size(); i++) {
            if (!targetIndex.contains(i)) {
                newColumnNames.add(columnNames.get(i));
            }
        }


        List<List<String>> newRows = new ArrayList<>();
        for (List<String> row : rows) {
            if (CollectionUtils.isEmpty(row)) {
                continue;
            }
            List<String> newRow = new ArrayList<>();

            for (int i = 0; i < row.size(); i++) {
                if (!targetIndex.contains(i)) {
                    newRow.add(row.get(i));
                }
            }

            newRows.add(newRow);

        }
        this.columnNames = newColumnNames;
        this.rows = newRows;
    }
}
