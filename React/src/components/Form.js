import '../styles/Form.css'
import React, {Fragment, useState} from 'react';

export default function Form(props) {

  const [datos, setDatos] = useState({
    nombreUsuario:'',
    apellidoUsuario:'',
    correoUsuario:'',
    numeroTelefono:'',
    departamentos:''
  })

  const handleInputChange = (event) => {
    console.log(event.target.value)
    setDatos({
      ...datos,
      [event.target.name] : event.target.value
    })
  }

  const enviarDatos = (event) => {
    event.preventDefault();
    console.log(datos.nombreUsuario + ' ' + datos.correoUsuario + ' ' + datos.departamentos)
  }


    return (
      <>
        <div className="updated" maxWidth={1200}>
          <section className="section">
            <div className="group-2-updated">
              <div
                backgroundImage="url(https://cdn.builder.io/api/v1/image/assets%2FYJIGb4i01jvw0SRdL5Bt%2Fe67ca22f446f46faa214bb00cf15b18e)"
                backgroundPosition="center"
                className="div"
                maxWidth={1200}
              >
                <section
                  backgroundImage="url(https://cdn.builder.io/api/v1/image/assets%2FYJIGb4i01jvw0SRdL5Bt%2Fe67ca22f446f46faa214bb00cf15b18e)"
                  backgroundPosition="center"
                  className="section"
                >
                  <div className="wrap-center-updated">
                    <div className="bitmap">
                      <picture>
                        <source
                          srcSet="https://cdn.builder.io/api/v1/image/assets%2F6779c8d94259456aa8a18297a34ed4d5%2F68e8e947916f4875847dd3d6fb6e4e98?format=webp&width=100 100w, https://cdn.builder.io/api/v1/image/assets%2F6779c8d94259456aa8a18297a34ed4d5%2F68e8e947916f4875847dd3d6fb6e4e98?format=webp&width=200 200w, https://cdn.builder.io/api/v1/image/assets%2F6779c8d94259456aa8a18297a34ed4d5%2F68e8e947916f4875847dd3d6fb6e4e98?format=webp&width=400 400w, https://cdn.builder.io/api/v1/image/assets%2F6779c8d94259456aa8a18297a34ed4d5%2F68e8e947916f4875847dd3d6fb6e4e98?format=webp&width=800 800w, https://cdn.builder.io/api/v1/image/assets%2F6779c8d94259456aa8a18297a34ed4d5%2F68e8e947916f4875847dd3d6fb6e4e98?format=webp&width=1200 1200w, https://cdn.builder.io/api/v1/image/assets%2F6779c8d94259456aa8a18297a34ed4d5%2F68e8e947916f4875847dd3d6fb6e4e98?format=webp&width=1600 1600w, https://cdn.builder.io/api/v1/image/assets%2F6779c8d94259456aa8a18297a34ed4d5%2F68e8e947916f4875847dd3d6fb6e4e98?format=webp&width=2000 2000w, https://cdn.builder.io/api/v1/image/assets%2F6779c8d94259456aa8a18297a34ed4d5%2F68e8e947916f4875847dd3d6fb6e4e98?format=webp&width=140 140w"
                          type="image/webp"
                        />
                        <img
                          loading="lazy"
                          src="https://cdn.builder.io/api/v1/image/assets%2F6779c8d94259456aa8a18297a34ed4d5%2F68e8e947916f4875847dd3d6fb6e4e98?width=140"
                          sizes="(max-width: 638px) 22vw, (max-width: 998px) 15vw, 10vw"
                          srcSet="https://cdn.builder.io/api/v1/image/assets%2F6779c8d94259456aa8a18297a34ed4d5%2F68e8e947916f4875847dd3d6fb6e4e98?width=100 100w, https://cdn.builder.io/api/v1/image/assets%2F6779c8d94259456aa8a18297a34ed4d5%2F68e8e947916f4875847dd3d6fb6e4e98?width=200 200w, https://cdn.builder.io/api/v1/image/assets%2F6779c8d94259456aa8a18297a34ed4d5%2F68e8e947916f4875847dd3d6fb6e4e98?width=400 400w, https://cdn.builder.io/api/v1/image/assets%2F6779c8d94259456aa8a18297a34ed4d5%2F68e8e947916f4875847dd3d6fb6e4e98?width=800 800w, https://cdn.builder.io/api/v1/image/assets%2F6779c8d94259456aa8a18297a34ed4d5%2F68e8e947916f4875847dd3d6fb6e4e98?width=1200 1200w, https://cdn.builder.io/api/v1/image/assets%2F6779c8d94259456aa8a18297a34ed4d5%2F68e8e947916f4875847dd3d6fb6e4e98?width=1600 1600w, https://cdn.builder.io/api/v1/image/assets%2F6779c8d94259456aa8a18297a34ed4d5%2F68e8e947916f4875847dd3d6fb6e4e98?width=2000 2000w, https://cdn.builder.io/api/v1/image/assets%2F6779c8d94259456aa8a18297a34ed4d5%2F68e8e947916f4875847dd3d6fb6e4e98?width=140 140w"
                          className="image"
                        />
                      </picture>
                      <div className="builder-image-sizer image-sizer" />
                    </div>
                    <div className="wrap-updated">
                      <a href="index.html" className="platform-tour">
                        <p>
                          <strong>INICIO</strong>
                        </p>
                      </a>
                      <a href="catalogo.html" className="design-education">
                        <p>
                          <strong>CATALOGO</strong>
                        </p>
                      </a>
                      <a href="aboutus.html" className="design-community">
                        <p>
                          <strong>SOBRE NOSOTROS</strong>
                        </p>
                      </a>
                      <a href="contactanos.html" className="enterprise">
                        <p>
                          <strong>
                            CONTACTANOS
                          </strong>
                        </p>
                      </a>
                    </div>
                    <div className="group-9-updated">
                      <div className="wrap-right-updated" />
                      <div className="sign-up-free">
                        <p>¿Ya tienes cuenta? Ingresa</p>
                      </div>
                    </div>
                  </div>
                  <div className="div-2" />
                  <div className="center">
                    <h2>
                      <strong>Formulario de Registro</strong>
                    </h2>
                  </div>
                  <div className="center-updated">
                    <div className="center-2">
                      <p>Nuevo Usuario</p>
                    </div>
                    <div className="center-3">
                      <p>Ingrese sus datos:</p>
                    </div>
                    <div className="center-updated-2" />
                  </div>
                </section>
              </div>
              <form className='row' onSubmit={enviarDatos}>
                <div className="div-3">
                  <div className="center-updated-3">
                  <input
                    type="text"
                    placeholder="Nombre"
                    name="nombreUsuario"
                    className="form-input"
                    required={true} 
                    onChange={handleInputChange}
                  />
                  <input
                    type="text"
                    placeholder="Apellido "
                    name="apellidoUsuario"
                    className="form-input"
                    required={true}
                    onChange={handleInputChange}
                  />
                  <input
                    type="text"
                    placeholder="Correo Electrónico "
                    name="correoUsuario"
                    className="form-input"
                    required={true}
                    onChange={handleInputChange}
                  />
                  <input
                    type="text"
                    placeholder="Num Telefono "
                    name="numeroTelefono"
                    className="form-input"
                    required={true}
                    onChange={handleInputChange}
                  />
                  
                  <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="departamentos" onChange={handleInputChange}>
                    <option selected>Departamentos</option>
                    <option value="Atlántida">Atlántida</option>
                    <option value="Colón">Colón</option>
                    <option value="Comayagua">Comayagua</option>
                    <option value="Copán">Copán</option>
                    <option value="Cortés">Cortés</option>
                    <option value="Choluteca">Choluteca</option>
                    <option value="El Paraíso">El Paraíso</option>
                    <option value="Francisco Morazán">Francisco Morazán</option>
                    <option value="Gracias a Dios">Gracias a Dios</option>
                    <option value="Intibucá">Intibucá</option>
                    <option value="Islas de la Bahía">Islas de la Bahía</option>
                    <option value="La Paz">La Paz</option>
                    <option value="Lempira">Lempira</option>
                    <option value="Ocotepeque">Ocotepeque</option>
                    <option value="Olancho">Olancho</option>
                    <option value="Santa Bárbara">Santa Bárbara</option>
                    <option value="Valle">Valle</option>
                    <option value="Yoro">Yoro</option>
                  </select>

                  <button className="btn btn-primary">Enviar</button>
                    
                    <div className="center-updated-4" />
                  </div>
                </div>
              </form>
              <div className="group-4-updated" />
              <div className="columns-center-updated">
                <div className="group-11-updated" />
              </div>
              <div className="columns-center-updated-2" />
              <div className="columns-center-updated-3">
                <div className="builder-columns div-4">
                  <div className="builder-column column">
                    <div className="group-14-updated">
                      <div className="design">
                        <p>It's good</p>
                      </div>{" "}
                      <div className="quickly-turn-ideas-into-powerful-screen-designs-with-intuitive-vector-based-drawing-and-flexible-layers">
                        <p>
                          Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                          sed do eiusmod tempor incididunt ut labore et dolore
                          magna aliqua. Ut enim ad minim veniam, quis nostrud
                          exercitation
                        </p>
                      </div>
                    </div>
                  </div>{" "}
                  <div className="builder-column column-2">
                    <div className="group-12-updated">
                      <div className="prototype-and-animate">
                        <p>It's great</p>
                      </div>
                      <div className="effortlessly-animate-transitions-and-add-micro-interactions-to-transform-your-static-screens-into-working-prototypes">
                        <p>
                          Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                          sed do eiusmod tempor incididunt ut labore et dolore
                          magna aliqua. Ut enim ad minim veniam, quis nostrud
                          exercitation
                        </p>
                      </div>
                    </div>
                  </div>
                  <div className="builder-column column-3">
                    <div className="group-13-updated">
                      <div className="collaborate">
                        <p>It's amazing</p>
                      </div>{" "}
                      <div className="seamlessly-navigate-the-entire-design-process-in-one-place-keeping-everyone-fully-engaged-and-notified-of-changes">
                        <p>
                          Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                          sed do eiusmod tempor incididunt ut labore et dolore
                          magna aliqua. Ut enim ad minim veniam, quis nostrud
                          exercitation
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>{" "}
              <div className="center-4">
                <p>
                  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
                  eiusmod tempor incididun
                </p>
              </div>{" "}
              <div className="center-updated-5" />{" "}
              <div className="columns-center-updated-4">
                <div className="builder-columns div-5">
                  <div className="builder-column column-4">
                    <div className="group-8-updated">
                      <div className="contact">Contact</div>{" "}
                      <div className="contact-lorem">
                        <p>Contact Lorem</p>
                      </div>
                    </div>
                  </div>{" "}
                  <div className="builder-column column-5">
                    <div className="group-5-updated">
                      <div className="about">About</div>{" "}
                      <div className="about-lorem">
                        <p>About Lorem</p>
                      </div>{" "}
                      <div className="lorem-for-startups">
                        <p>Lorem For Startups</p>
                      </div>{" "}
                      <div className="pricing">
                        <p>Pricing</p>
                      </div>{" "}
                      <div className="students-teachers">
                        <p>Students &amp; Teachers</p>
                      </div>{" "}
                      <div className="jobs">
                        <p>Jobs</p>
                      </div>
                    </div>
                  </div>{" "}
                  <div className="builder-column column-6">
                    <div className="group-6-updated">
                      <div className="platform">Platform</div>{" "}
                      <div className="freehand">
                        <p>Freehand</p>
                      </div>{" "}
                      <div className="boards">Boards</div>{" "}
                      <div className="studio">Studio</div>{" "}
                      <div className="craft">Craft</div>{" "}
                      <div className="prototype">Prototype</div>
                    </div>
                  </div>{" "}
                  <div className="builder-column column-7">
                    <div className="group-7-updated">
                      <div className="resources">Resources</div>{" "}
                      <div className="design-resources">
                        <p>Design Resources</p>
                      </div>{" "}
                      <div className="product-training">Product Training</div>{" "}
                      <div className="help-center">Help Center</div>{" "}
                      <div className="knowledge-base">Knowledge Base</div>{" "}
                      <div className="community">Community</div>
                    </div>
                  </div>{" "}
                  <div className="builder-column column-8">
                    <div className="blog">
                      <p>Blog</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
        </div>{" "}
        
      </>
    );
  }