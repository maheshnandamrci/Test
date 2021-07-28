package com.adp.test.changeprovider.serviceimpl;

import org.springframework.stereotype.Service;

import com.adp.test.changeprovider.bean.ChangeReceipt;
import com.adp.test.changeprovider.exception.InvalidPaymentException;
import com.adp.test.changeprovider.service.ChangeProvide;
import com.adp.test.changeprovider.util.Constants;

@Service
public class ChangeProvideImpl implements ChangeProvide {

	@Override
	public ChangeReceipt retrieveChange(Double billAmount, Double paidAmount) {

		ChangeReceipt response = new ChangeReceipt();
		double change = 0;

		if (paidAmount == 0) {
			// throw new InvalidRoleIdException("Exception Occurred");
			response.setMessage("Please pay valid amount to proceed");
			return response;
		}

		change = paidAmount - billAmount;

		int twentyDollarChange = 0, tenDollarChange = 0, fiveDollarChange = 0, oneDollarChange = 0, quarterChange = 0,
				nickelChange = 0, dimeChange = 0, pennyChange = 0;

		if (change < 0) {
			response.setTotalChangeBackToUser((float) change);
			response.setMessage("The customer still need to pay " + (float) change + "$");

			return response;
		} else {
			float totalChange = (float) change;

			// Here we will be calculating the change if that is more than a Dollar
			while (change >= Constants.oneDollar) {

				if (change >= Constants.twentyDollar) { // Here if change is 50$
					twentyDollarChange = (int) change / Constants.twentyDollar;
					change %= Constants.twentyDollar; // Here the 50$ % 20$ returns 2 20$ and 10$ left for next check
				} else if (change >= Constants.tenDollar) {
					tenDollarChange = (int) change / Constants.tenDollar;
					change %= Constants.tenDollar;
				} else if (change >= Constants.fiveDollar) {
					fiveDollarChange = (int) change / Constants.fiveDollar;
					change %= Constants.fiveDollar;
				} else {
					oneDollarChange = (int) change / Constants.oneDollar;
					change %= Constants.oneDollar;
				}
			}

			// Here we will be calculating the change if it is less than a Dollar
			while (change != 0) {

				if (change < 1) {
					change = (float) change * 100;
				} else if (change >= Constants.twentyFiveCents) {
					quarterChange = (int) change / Constants.twentyFiveCents;
					change %= Constants.twentyFiveCents;
				} else if (change >= Constants.tenCents) {
					dimeChange = (int) change / Constants.tenCents;
					change %= Constants.tenCents;
				} else if (change >= Constants.fiveCents) {
					nickelChange = (int) change / Constants.fiveCents;
					change %= Constants.fiveCents;
				} else {
					pennyChange = (int) change;
					change = 0;
				}
			}

			response.setTotalChangeBackToUser((float) totalChange);
			response.setDollarChange("$20 = " + twentyDollarChange + ", $10 = " + tenDollarChange + ", $5 = "
					+ fiveDollarChange + ", $1 = " + oneDollarChange);
			response.setCoinsChange("Quarters = " + quarterChange + ", Dimes = " + dimeChange + ", Nickles = "
					+ nickelChange + ", Pennies = " + pennyChange);
			response.setMessage("Success");

			return response;
		}
	}

}
