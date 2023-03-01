Voyage
Part 1
To start, we want to be able to receive orders and assign them to voyages, if a voyage satisfies the order’s needs.
An order specifies the origin and destination port, as well as a dropoff date (the date the client will have the goods
ready to ship), and a target delivery date (the deadline for the goods to be delivered. A voyage is a shipping route
between an origin and destination port, and it has a specific departure date and arrival date.
How you choose to model this system is up to you. Write a method book_order that will assign the given order to the
earliest possible voyage by departure date.
----
Part 2
We’re gaining traction and we’re getting too many bookings that fill our`capacity. You can only load a maximum number
of orders on each voyage. Extend your model to account for this restriction on capacity
----
Part 3
As you may know, supply chains are kind of messy right now, due to the backlog created by the pandemic. We’re finding
that we often can’t book orders because there is no capacity left in our shipments with our current scheduling. But
many times, if we move things around in the schedule we are able to accommodate more orders.
For example:
- Voyage1: SZ (08/09) -> LA (08/20)
    - Order1: Dropoff (08/09), Target Delivery (08/30)
- Voyage2: SZ (08/10) -> LA (08/21)
    - {Available capacity}
      If we receive an Order2 from SZ to LA with dropoff at 08/09 and target delivery at 08/20, we can’t fulfi‍‍‌‌‍‍‌‌‌‌‍‌‍‍‌‌‌‌ll it, since
      Voyage 1 is capped, and Voyage 2 arrives too late. But if we move Order1 to Voyage2, we’d be able to book Order2 as well.
      Modify your system so that an order is booked if rescheduling a single other shipment opens capacity.
