package pagination;

import java.util.List;

public interface Pagination<T> {
	List<T> getPageData(int pageNo);
	int getTotalPage();
}
