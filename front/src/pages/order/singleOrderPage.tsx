import {NextPage} from "next";
import {useEffect} from "react";
import {useGetOrderById} from "../../hooks/useGetOrderById";

const SingleOrderPage: NextPage = () => {

    //ToDo add extracting of id from url??? here
    const orderId = 1;
    const {order} = useGetOrderById(orderId);

    //ToDo delete this after showing of specialists
    useEffect(() => {
        console.log(order)
    }, [order])


    return (
        <>
        </>
    )
}

export default SingleOrderPage;