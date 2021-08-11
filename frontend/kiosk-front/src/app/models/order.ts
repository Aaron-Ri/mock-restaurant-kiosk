import { Food } from "./food";
export interface Order {

    orderId: number;

	orderTotalBeforeTax: number;

    orderTax: number;

    orderAfterTax: number;

    orderItems: Array<Food>;


}
