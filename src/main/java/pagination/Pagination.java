package pagination;

import java.util.List;

public interface Pagination<T> {
	int getTotalRecord();
	List<T> getPageData(int pageSize, int start);
}
