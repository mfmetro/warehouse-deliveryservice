package de.metro.code.warehouse.deliveryservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.metro.code.warehouse.deliveryservice.services.ConfirmationService;

@RestController
public class ConfirmationController {

    @Autowired
    private ConfirmationService confirmationService;

    @RequestMapping(path = "/confirmFulfilledOrder/{id}", method = RequestMethod.POST)
    public @ResponseBody String post(final @PathVariable("id") String orderId) {
        confirmationService.confirmOrder(orderId);
        return orderId;
    }
}
