import {useEffect, useState} from "react";
import {LOCAL_BACK_URL} from "../config/variables";

export const useGetOrderById = (orderId:number) => {
  const url = LOCAL_BACK_URL + '/api/v1/order/' + orderId;

  const [order, setOrder] = useState([]);

  useEffect(() => {
    fetch(url)
    .then(resp => resp.json())
    .then(json => setOrder(json))
    .catch((error) => {
      console.log("ERROR " + error)
    })
  }, [])

  return {order};
}
