public class OrderTest {
    public static void main(String[] args) {
        PriceCalculator priceCalculator = new PriceCalculator();
        OrderHandler orderHandler = new OrderHandler();
        InvoiceService invoiceService = new InvoiceService();
        NotificationService notificationService = new NotificationService();

        Order orderAction = new OrderAction(priceCalculator, orderHandler, invoiceService, notificationService);
        
        OrderDetails details = new OrderDetails();
        details.setCost(100.0);
        details.setCount(15);
        details.setClient("Cyriljosh Juan");
        details.setLocation("Central Avenue");
        details.setInvoiceFile("invoice123.jpg");
        details.setContactEmail("cyriljoshroberto.juan@neu.edu.ph");
        
        orderAction.processOrder(details);
    }
}