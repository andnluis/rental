import React from 'react'
import Card from './Card'

const cards = [
  {
    id: 1,
    title: "Fazt Web",
    image: '',
    url: "https://faztweb.com",
  },
  {
    id: 4,
    title: "Fazt Web",
    image: '',
    url: "https://faztweb.com",
  },
  {
    id: 5,
    title: "Fazt Web",
    image: '',
    url: "https://faztweb.com",
  },
  {
    id: 6,
    title: "Fazt Web",
    image: '',
    url: "https://faztweb.com",
  },
  {
    id: 7,
    title: "Fazt Web",
    image: '',
    url: "https://faztweb.com",
  },
  
  {
    id: 8,
    title: "Fazt Web",
    image: '',
    url: "https://faztweb.com",
  },
  {
    id: 9,
    title: "Fazt Web",
    image: '',
    url: "https://faztweb.com",
  },
  {
    id: 10,
    title: "Fazt Web",
    image: '',
    url: "https://faztweb.com",
  },
  {
    id: 11,
    title: "Fazt Web",
    image: '',
    url: "https://faztweb.com",
  },
  {
    id: 12,
    title: "Fazt Web",
    image: '',
    url: "https://faztweb.com",
  },
  {
    id: 13,
    title: "Fazt Web",
    image: '',
    url: "https://faztweb.com",
  },
  {
    id: 14,
    title: "Fazt Web",
    image: '',
    url: "https://faztweb.com",
  },
  
  {
    id: 15,
    title: "Fazt Web",
    image: '',
    url: "https://faztweb.com",
  },
  {
    id: 16,
    title: "Fazt Web",
    image: '',
    url: "https://faztweb.com",
  },
  {
    id: 17,
    title: "Fazt Web",
    image: '',
    url: "https://faztweb.com",
  },
  {
    id: 18,
    title: "Fazt Web",
    image: '',
    url: "https://faztweb.com",
  },
  {
    id: 2,
    title: "Fazt Blog",
    image: '',
    url: "https://blog.faztweb.com",
  },
  {
    id: 3,
    title: "Fazt Youtube",
    image: '',
    url: "https://youtube.com/fazttech",
  },
];

function Cards() {
    return (
      <div className="container d-flex justify-content-center align-items-center h-100 ">
        <div className="row d-flex justify-content-center h-100">
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