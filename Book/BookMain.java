class Main
{
    public static void main(String[] args)
    {
        Book book1 = new Book();
        System.out.println(book1.getShortName());
        Book book2 = new Book("author", "Title", 100);
        System.out.println(book2.getShortName());

        System.out.println();

        PrintedBook pbook1 = new PrintedBook();
        System.out.println(pbook1.getShortName());
        System.out.println(" price = " + pbook1.getPrice());
        PrintedBook pbook2 = new PrintedBook("author", "Printed: Title", 100, CoverType.Softcover);
        System.out.println(pbook2.getShortName());
        System.out.println(" price = " + pbook2.getPrice());

        System.out.println();

        EBook ebook1 = new EBook("author2", "Digitalised: Title", 100, 12);
        System.out.println(ebook1.getShortName());
        System.out.println(" price = " + ebook1.getPrice());

        System.out.println();

        System.out.println(book1);
        System.out.println(pbook1);
        System.out.println(pbook2);
        System.out.println(ebook1);

        System.out.println();

        System.out.println(book1.createReference("articlename", 10, 20));
        System.out.println(pbook1.createReference("articlename", 10, 20));
        System.out.println(ebook1.createReference("articlename", "2020/04/11"));
        System.out.println(ebook1.createReference("articlename", 10, 20));
    }
}
   
