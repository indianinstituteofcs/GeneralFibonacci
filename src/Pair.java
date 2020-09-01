
public class Pair<T1,T2> {
	T1 first;
	T2 second;
	
	public Pair(T1 inF, T2 inS){
		first = inF;
		second = inS;
	}
	
	public T1 first(){
		return first;
	}
	
	public T2 second(){
		return second;
	}
	
	public void setFirst(T1 value) {
		first = value;
	}

	public void setSecond(T2 value) {
		second = value;
	}
	
	public Boolean equals(Pair<T1,T2 >value) {
		return (first == value.first()) && (second == value.second());
	}
}
