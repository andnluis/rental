import React from 'react'
import Card from './Card'


const cards = [
  {
    id: 1,
    title: "Fazt Web",
  //  image: image1,
    url: "https://faztweb.com",
  },
  {
    id: 2,
    title: "Fazt Blog",
  //  image: image2,
    url: "https://blog.faztweb.com",
  },
  {
    id: 3,
    title: "Fazt Youtube",
   // image: image3,
    url: "https://youtube.com/fazttech",
  },
];

function Cards() {
    return (
      <div className="container d-flex justify-content-center align-items-center h-100">
        <div className="row">
          {cards.map(({ title, image, url, id }) => (
            <div className="col-md-4" key={id}>
              <Card imageSource={image} title={title} url={url} />
            </div>
          ))}
        </div>
      </div>
    );
  }

export default Cards