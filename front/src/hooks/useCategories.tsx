import { useEffect, useState } from 'react';
import { LOCAL_BACK_URL } from '../config/variables';

export const useGetCategories = () => {
  const url = LOCAL_BACK_URL + '/api/v1/category/';

  const [categories, setCategories] = useState<any[]>([]);

  useEffect(() => {
    fetch(url)
      .then((resp) => resp.json())
      .then((json) => setCategories(json))
      .catch((error) => {
        console.log('ERROR ' + error);
      });
  }, []);

  return { categories };
};
