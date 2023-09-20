package design.patterns.behavioural;

// Iterator interface
interface Iterator<T> {
	boolean hasNext();
	T next();
}

// Aggregate interface
interface Library {
	Iterator<String> createIterator();
}

// Concrete Iterator
class BookIterator implements Iterator<String> {
	
	private String[] books;
	private int position = 0;
	
	public BookIterator(String[] books) {
		this.books = books;
	}

	@Override
	public boolean hasNext() {
		return position < books.length;
	}

	@Override
	public String next() {
		if(hasNext()) {
			return books[position ++];
		}
		return null;
	}
	
}

// Concrete Aggregate
class BookLibrary implements Library {
	
	private String[] books;
	
	public BookLibrary(String[] books) {
		this.books = books;
	}

	@Override
	public Iterator<String> createIterator() {
		return new BookIterator(books);
	}
}

public class IteratorExample {
	public static void main(String[] args) {
		String[] books = {"Book1", "Book2", "Book3"};
		Library library = new BookLibrary(books);
		
		Iterator<String> iterator = library.createIterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
