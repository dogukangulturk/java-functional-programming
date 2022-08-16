package org.javaturk.oofp.ch12.terminal;

import static org.javaturk.oofp.ch12.util.StreamUtil.print;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.javaturk.oofp.ch12.domain.Book;

import static org.javaturk.oofp.ch12.domain.BookFactory.*;
import static org.javaturk.oofp.ch12.domain.CollectionFactory.*;

public class ForEachOrderedExample2 {

	public static void main(String[] args) {
		runNamesExamples();
//		runBooksExamples();
	}
	
	public static void runNamesExamples() {
		Consumer<String> printConsumer = s -> System.out.println(s);
		Consumer<String> printLengthConsumer = s -> System.out.println(s + " - " + s.length());

		List<String> nameList = getNameList();
		print(nameList);

		System.out.println("\nName list");
		
		Stream<String> stream = nameList.stream();
		stream.forEach(printConsumer);
		
		System.out.println("\nName list ordered");
		
		stream = nameList.stream();
		stream.forEachOrdered(printConsumer);
		
		System.out.println("\nName set");
		
		Set<String> nameSet = getNameSet();
		stream = nameList.stream();
		stream.forEach(printConsumer);
		
		System.out.println("\nName set ordered");
		
		stream = nameList.stream().sorted();
		stream.forEachOrdered(printConsumer);
	}

	public static void runBooksExamples() {
		Consumer<Book> printConsumer = b -> System.out.println(b);
		Consumer<Book> printPageCountConsumer = b -> System.out.println(b.getTitle() + " - " + b.getPages());
		
		List<Book> books = getBookList();
		System.out.println("\n* * * Print consumer * * *");
		books.stream().forEach(printConsumer);
		System.out.println("\n* * * Print page count consumer * * *");
		books.stream().forEach(printPageCountConsumer);
		System.out.println("\n* * * Print page count consumer * * *");
		books.stream().forEach(b -> System.out.println(b.getTitle() + " - " + b.getPages())); // Either way can be used!
	}
}
