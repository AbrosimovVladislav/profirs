import {useEffect, useState} from "react";
import {LOCAL_BACK_URL} from "../config/variables";

export const useGetSpecialistsByCategoryId = (categoryId:number) => {
  const url = LOCAL_BACK_URL + '/api/v1/specialist/' + categoryId;

  const [specialists, setSpecialists] = useState([]);

  useEffect(() => {
    fetch(url)
    .then(resp => resp.json())
    .then(json => setSpecialists(json))
    .catch((error) => {
      console.log("ERROR " + error)
    })
  }, [])

  return {specialists};
}
