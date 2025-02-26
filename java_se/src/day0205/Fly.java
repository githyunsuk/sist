package day0205;

/**
 * 나는 것들의 일의 목록 정의. 
 */
public interface Fly {

	/**
	 * 날기 위해서는 양력이 있어야한다.
	 * @return 양력
	 */
	public abstract String lift();
	/**
	 * 날기 위해서는 추진력이 있어야한다.
	 * @return 추진력
	 */
	public abstract String thrust();
}
