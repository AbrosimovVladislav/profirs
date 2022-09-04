import {useEffect, useState} from "react";
import {LOCAL_BACK_URL} from "../config/variables";

export const useGetQuestionsByCategoryId = (id:number) => {
  const url = LOCAL_BACK_URL + '/api/v1/category-question/' + id;

  const [questions, setQuestions] = useState([]);

  useEffect(() => {
    fetch(url)
    .then(resp => resp.json())
    .then(json => setQuestions(json))
    .catch((error) => {
      console.log("ERROR " + error)
    })
  }, [])

  return {questions};
}
