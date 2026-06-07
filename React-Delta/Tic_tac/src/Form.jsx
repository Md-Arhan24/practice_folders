import { useState } from "react";

export default function Form() {
  const [formData, setFormData] = useState({
    username: "",
    email: "",
    password: "",
  });

  function handleFormData(event) {
    //we have to access the name and value
    let field = event.target.name;
    let value = event.target.value;
   

    //re rendering the entier
    setFormData((prev_obj) => {
      
      return { ...prev_obj, [field]: value };
    });
  }
  function handleSubmit(event) {
    event.preventDefault();
    console.log(formData);
    setFormData({
      username: "",
      email: "",
      password: "",
    });
  }

  return (
    <>
      <form action="" onSubmit={handleSubmit}>
        <label htmlFor="username">UserName:</label>
        <input
          type="text"
          value={formData.username}
          onChange={handleFormData}
          id="username"
          name="username"
        />
        <br />
        <label htmlFor="email">email:</label>
        <input
          type="text"
          value={formData.email}
          onChange={handleFormData}
          id="email"
          name="email"
        />
        <br />
        <label htmlFor="password">password:</label>
        <input
          type="text"
          value={formData.password}
          onChange={handleFormData}
          id="password"
          name="password"
        />
        <button type="submit">submit</button>
      </form>
    </>
  );
}
