public class OrderAction implements Order {
    private final PriceCalculator priceCalculator;
    private final OrderHandler orderHandler;
    private final InvoiceService invoiceService;
    private final NotificationService notificationService;

    public OrderAction(PriceCalculator priceCalculator, OrderHandler orderHandler,
                       InvoiceService invoiceService, NotificationService notificationService) {
        this.priceCalculator = priceCalculator;
        this.orderHandler = orderHandler;
        this.invoiceService = invoiceService;
        this.notificationService = notificationService;
    }

    @Override
    public void processOrder(OrderDetails details) {
        double totalAmount = priceCalculator.computeTotal(details.getCost(), details.getCount());
        System.out.println("Total Amount: $" + totalAmount);
        
        orderHandler.initiateOrder(details.getClient(), details.getLocation());
        invoiceService.createInvoice(details.getInvoiceFile());
        notificationService.dispatchEmail(details.getContactEmail());
    }
}