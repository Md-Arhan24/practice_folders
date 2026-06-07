import { useState } from "react";
import './MovieReviewCard.css';
import ShowComments from "./ShowComments";
 import { useFormik } from 'formik';
export default function MovieReviewCard() {
  // const [movieReview, setMovieReview] = useState({
  //   username: "",
  //   remark: "",
  //   rating: "",
  // });
  const validate = values => {
   const errors = {};
   if (!values.username) {
     errors.username = 'Required username';
   }
 
   if (!values.remark) {
     errors.remark = 'Required remark';
   }
 
   if (!values.rating) {
     errors.rating = 'Required rating.';
   }
 
   return errors;
 };
  const formik = useFormik({
     initialValues: {
       username: '',
       remark:'',
       rating:''
     },
     validate,
     onSubmit: values => {
       alert(JSON.stringify(values, null, 2));
     },
   });
  const[comments,SetComments] = useState([{}]);
  // const[isValid,setIsvalid] = useState(true);

  // function handleMovieReview(event) {

  //   setMovieReview((prev_rev) => {
  //     return { ...prev_rev, [event.target.name]: event.target.value };
  //   });
  // }
 
  // function handleSubmit(event){
  //  event.preventDefault();
  //  if(!movieReview.username){
  //   setIsvalid(false);
  //   return;
  //  }
  //  const obj = {...movieReview};//re render the object
  //  SetComments([...comments,obj]);

  //   setMovieReview({
  //   username: "",
  //   remark: "",
  //   rating: "",
  // });

  
  return(
    <div id="card">
      <form action="/" onSubmit={formik.handleSubmit}>
        <label htmlFor="username">Name:</label>
        <input
          type="text"
          name="username"
          id="username"
          value={formik.values.username}
          onChange={formik.handleChange}
        />
        
        {formik.errors.username ? <div>{formik.errors.username}</div> : null}
        <label htmlFor="remark">remark:</label>
        <input
          type="text"
          name="remark"
          id="remark"
          value={formik.values.remark}
          onChange={formik.handleChange}
        />
        {formik.errors.remark ? <div>{formik.errors.remark}</div> : null}
        <label htmlFor="rating">rating:</label>
        <input
          type="text"
          name="rating"
          id="rating"
          value={formik.values.rating}
          onChange={formik.handleChange}
          min={1}
          max={5}
        />
        {formik.errors.rating ? <div>{formik.errors.rating}</div> : null}
        <button type="submit">Submit</button>

      </form>
      <ShowComments comment={comments}/>
    </div>
  );
}
